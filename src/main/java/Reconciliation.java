import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Reconciliation {

    public static void main(String[] args) {
        String[] temp = new String[11];
        temp[0] = "D0-POS";
        temp[1] = "AAPL 100";
        temp[2] = "GOOGL 100";
        temp[3] = "Cash 100";
        temp[4] = "D1-TRN";
        temp[5] = "AAPL SL 50 500";
        temp[6] = "GOOGL BY 10 200";
        temp[7] = "D1-POS";
        temp[8] = "AAPL 60";
        temp[9] = "GOOGL 100";
        temp[10] = "Cash 300";

        reconcile(temp);

    }

    static void reconcile(String[] fileContents) {
        int cash = 0;
        int length = fileContents.length;
        Map<String, Integer> sharePriceMap = new HashMap<String, Integer>();
        Map<String, Integer> sharePriceMapTRan = new HashMap<String, Integer>();
        //sharePriceMapTRan.put("Cash",0);
        boolean isPOS = false;
        boolean isTRN = false;
        int i = 0;
        while (i < fileContents.length) {
            if (fileContents[i].indexOf("-POS") != -1) {
                isPOS = true;
                isTRN =false;

                i++;
                continue;
            }
            if (!isTRN && fileContents[i] != " " && fileContents[i].indexOf("-TRN") == -1) {
                String[] pos = fileContents[i].split(" ");

                sharePriceMap.put(pos[0], Integer.parseInt(pos[1]));
                i++;
                continue;

            }
            if (fileContents[i].indexOf("-TRN") != -1 ) {
                isPOS = false;
                isTRN = true;

                i++;
                continue;
            }
            if (!isPOS && fileContents[i] != " " && fileContents[i].indexOf("-POS") == -1) {
                String[] pos = fileContents[i].split(" ");
                if (pos[1].equalsIgnoreCase("SL")) {
                    if(sharePriceMapTRan.containsKey(pos[0])){
                        sharePriceMapTRan.put(pos[0], sharePriceMapTRan.get(pos[0]) - Integer.parseInt(pos[2]));
                        
                    }
                    if(sharePriceMapTRan.containsKey("Cash")){
                        sharePriceMapTRan.put("Cash", sharePriceMapTRan.get("Cash") + Integer.parseInt(pos[3]));
                    }
                    if(!sharePriceMapTRan.containsKey(pos[0])){
                        sharePriceMapTRan.put(pos[0], sharePriceMap.get(pos[0]) - Integer.parseInt(pos[2]));
                        
                    }
                    if(!sharePriceMapTRan.containsKey("Cash")){
                        sharePriceMapTRan.put("Cash", sharePriceMap.get("Cash") + Integer.parseInt(pos[3]));
                    }
                    
                    i++;
                    continue;
                } else if (pos[1].equalsIgnoreCase("BY")) {
                    if(sharePriceMapTRan.containsKey(pos[0])){
                        sharePriceMapTRan.put(pos[0], sharePriceMapTRan.get(pos[0]) + Integer.parseInt(pos[2]));
                        
                    }
                    if(sharePriceMapTRan.containsKey("Cash")){
                        sharePriceMapTRan.put("Cash", sharePriceMapTRan.get("Cash") - Integer.parseInt(pos[3]));
                    }
                    if(!sharePriceMapTRan.containsKey(pos[0])){
                        sharePriceMapTRan.put(pos[0], sharePriceMap.get(pos[0]) + Integer.parseInt(pos[2]));
                        
                    }
                    if(!sharePriceMapTRan.containsKey("Cash")){
                        sharePriceMapTRan.put("Cash", sharePriceMap.get("Cash") - Integer.parseInt(pos[3]));
                    }

                    i++;
                    continue;
                }
            }
        }

        Set<String> keySet = sharePriceMap.keySet();
        for (String key : keySet) {
            Integer valMap1 = sharePriceMap.get(key);
            Integer valMap2 = sharePriceMapTRan.get(key);
            if (valMap1 != valMap2) {
                System.out.println(key + " " + String.valueOf(valMap2 - valMap1));
            }
        }

    }
}
