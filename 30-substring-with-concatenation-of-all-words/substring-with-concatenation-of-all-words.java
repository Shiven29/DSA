class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordCount * wordLen;
        List<Integer> result = new ArrayList<>();

        HashMap<String, Integer> requiredMap = new HashMap<>();
        for(String word : words){
            requiredMap.put(word, requiredMap.getOrDefault(word,0)+1);
        }

        for(int i = 0; i<wordLen; i++){
            int left = i;
            int right =i;
            int count = 0;
            HashMap<String, Integer> foundMap = new HashMap<>();

            while(right+wordLen <= s.length()){
                String word = s.substring(right,right+wordLen);
                right+=wordLen;

                if(!requiredMap.containsKey(word)){
                    foundMap.clear();
                    count = 0;
                    left = right;
                }else{
                    foundMap.put(word,foundMap.getOrDefault(word,0)+1);
                    count++;

                    while(foundMap.get(word)>requiredMap.get(word)){
                        String leftWord = s.substring(left,left+wordLen);
                        foundMap.put(leftWord,foundMap.get(leftWord)-1);
                        if(foundMap.get(word)==0){
                            foundMap.remove(word);
                        }
                        left+= wordLen;
                        count--;
                    }
                    if(count == wordCount){
                        result.add(left);
                        String leftWord = s.substring(left,left+wordLen);
                        foundMap.put(leftWord,foundMap.get(leftWord)-1);
                        if(foundMap.get(leftWord) == 0){
                            foundMap.remove(leftWord);
                        }
                        left+=wordLen;
                        count--;
                    }
                }
            }
        }
        return result;
    }
}