package com.jepanet.model.io;

import com.jepanet.model.Network;
import org.apache.commons.lang3.StringUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class INPReader {

    private static final String[] SECTIONS = {
        "[TITLE", //0: Title
        "[JUNCTIONS", //1: Junctions
    };
    
    /*'[TITLE',      {0: Title}
     '[JUNCTIONS',  {1: Junctions}
     '[RESERVOIRS', {2: Reservoirs}
     '[TANKS',      {3: Tanks}
     '[PIPES',      {4: Pipes}
     '[PUMPS',      {5: Pumps}
     '[VALVES',     {6: Valves}
     '[CONTROLS',   {7: Controls}
     '[RULES',      {8: Rules}
     '[DEMANDS',    {9: Demands}
     '[ROUGHNESS',  {10: Roughness}
     '[ENERGY',     {11: Energy}
     '[EMITTERS',   {12: Emitters}
     '[SOURCES',    {13: Sources}
     '[PATTERNS',   {14: Patterns}
     '[CURVES',     {15: Curves}
     '[QUALITY',    {16: Quality}
     '[STATUS',     {17: Status}
     '[REACTIONS',  {18: Reactions}
     '[MIXING',     {19: Mixing}
     '[REPORT',     {20: Report}
     '[TIMES',      {21: Times}
     '[OPTIONS',    {22: Options}
     '[END',        {23: End}
     '[COORDINATES',{24: Coordinates}
     '[VERTICES',   {25: Vertices}
     '[LABELS',     {26: Labels}
     '[BACKDROP',   {27: Backdrop}
     '[DIAMETERS',  {28: Diameters}
     '[TAGS');      {29: Tags}*/
    

    private final File file;
    private int section;
    private String comment;
    private String prevComment;
    private List<String> tokenList;
    private int numTokens;

    public INPReader(File file) throws FileNotFoundException {
        if (file.exists())
            this.file = file;
        else
            throw new FileNotFoundException();
        section = -1;
    }
    
    public INPReader(String file) throws FileNotFoundException  {
        this(new File(file));
    }
    
    
    public Network getNework() throws FileNotFoundException, IOException {
        Network result = new Network();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
               
               // Parse line into tokens
               String lineNotComments = stripAndSaveComment(line);
               tokenList = tokenise(lineNotComments);
               numTokens = tokenList.size();
               
               // Check if line begins a new input section
               if ((numTokens > 0) && (tokenList.get(0).charAt(0) == '[')) {
                   startNewSection();
               } 
               else if (section == 0 && numTokens > 0)
                   readTitleData(result, line);

            }
        }
        
        return result;
        
    }
    
    private List<String> tokenise(String line) {
        String regex = "\"([^\"]*)\"|(\\S+)";
        List<String> result = new ArrayList<>(numTokens);
        numTokens = 0;        
        Matcher m = Pattern.compile(regex).matcher(line);
        while (m.find()) {
            numTokens++;
            if (m.group(1) != null) {
                result.add(m.group(1));
            } else {
                 result.add(m.group(2));
            }
        }
        
        return result;
    }

    private String stripAndSaveComment(String line) {
        prevComment = comment;
        comment = "";
        int pos = line.indexOf(';');
        if (pos > 0){
            comment = line.substring(pos + 1);
            return line.substring(0, pos);
        } else if (pos == -1) return line;
        else return "";
    }    

    private void startNewSection() {
        int k = -1;
        int i = 0;
        String sectionToken = tokenList.get(0).toUpperCase().substring(0, 5);
        for (String s: SECTIONS){//TODO: use while here
            if (s.substring(0, 5).equals(sectionToken)){
                k = i;
                break;
            }
            i++;
        } 
        section = k;
    }

    private void readTitleData(Network net, String line) {
        if (StringUtils.isEmpty(net.getTitle()))
            net.setTitle(line);
        else
            net.addNote(line);
    }
}
