


public class exercise18 {
    
    public static void main(String args[]){
        /* String number = ""+99888;
        String[] arr= new String[number.length()];
		for(int i =0; i< number.length(); i++){
			arr[i]= String.valueOf(number.charAt(i));
		}
		HashMap<String,Integer> hm = new HashMap<String,Integer>();
		for(int i=0; i<arr.length;i++){
			hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
		}

        
        Collection getValues = hm.values();
        Iterator i = getValues.iterator();
        Integer s=0;
        while (i.hasNext()) {
            if(s < i.next()){

            }
		
		System.out.println(hm.get("8")); */

        String number = ""+ 223228888;
        
        int[] hash1 = new int[10];
        for(int i =0; i<number.length(); i++){
            int a = number.charAt(i)-'0';
            hash1[a]+=1;

        }

        int s=0;
        for(int i =0; i<10; i++){
              
              if(hash1[s]<hash1[i]){
                s = i;
              }
              else if(hash1[s]==hash1[i]) continue;

              else continue;


        }


        System.out.print(s);
		    
		
    }
    
}
