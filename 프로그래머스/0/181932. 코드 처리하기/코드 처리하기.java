class Solution {
    public String solution(String code) {
        String ret = "";
        int mode = 0;
        
        for(int idx =0; idx < code.length(); idx++){
            //String at = String.valueOf(code.charAt(idx));
            switch(mode){
                case 0:
                    //if(!at.equals("1") && (idx % 2 == 0)){
                    if(code.charAt(idx) != '1' && (idx % 2 == 0)){
                        ret += code.charAt(idx);
                    //} else if(at.equals("1")){
                    } else if(code.charAt(idx) == '1'){    
                        mode = 1;
                    }
                    break;
                case 1:
                    //if(!at.equals("1") && idx % 2 == 1){
                    if(code.charAt(idx) != '1' && (idx % 2 == 1)){
                        ret += code.charAt(idx);
                    //} else if(at.equals("1")){
                    } else if(code.charAt(idx) == '1'){        
                        mode = 0;
                    }
                    break;
            }
        }
        
        return (ret.isEmpty() ? "EMPTY" : ret);
    }
}