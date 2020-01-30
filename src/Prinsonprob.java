public class Prinsonprob {

    public static int prisonProb(int n){
        int[] arr = new int[n];
        int counter=0;
        boolean isOn= true;
        for (int i = 0; i <n ; i++) {
            arr[i]=1;
        }
        arr[0]=0;
        int enters= 0;
        while(counter!=n-1){
            int RandIndex = (int)(Math.random()*100);
            if(isOn && RandIndex==0 ){
                isOn=false;
                counter++;
            }
            else if(!isOn &&arr[RandIndex]==1){
                isOn=true;
                arr[RandIndex]=0;
            }
            enters++;
        }
        return enters;
    }

    public static void main(String[] args) {
        int x = prisonProb(100);
        System.out.println(x);
    }
}
