public class TlatKrav {
    /**
     * in this function we check the statistic of who win in duel3D, when player a kill 100%,player b kill 80%, player c kill 50%.
     * @param num how much iterations we want to check.
     */

    public static void duel3D(int num){
        double Bhit=0.8,Chit=0.5;
        double aWin=0,bWin=0,cWin=0;
        for (int i = 0; i <num ; i++) {
            int scenario = (int)(Math.random()*2)+1;
            switch (scenario){
                case 1:
                    double isKilled = Math.random();
                    if(isKilled>Chit) cWin++;
                    else aWin++;
                break;
                case 2:
                    double isAkilled = Math.random();
                    if(isAkilled<=Bhit){
                        boolean[] live ={true,true};
                        while (live[1] && live[0]) {
                            double isBkilled = Math.random();
                            double isCkilled = Math.random();
                            if (isBkilled >= Chit) {
                                live[1] = false;
                                cWin++;
                            }
                            else if(isCkilled <= Bhit) {
                                bWin++;
                                live[0] = false;
                            }
                        }
                    }
                    else{
                       isAkilled=Math.random();
                       if(isAkilled>=Chit) cWin++;
                       else aWin++;
                    }
                break;
            }
        }
        System.out.println("Player A won:" + aWin/num +"\n Player B won:" + bWin/num + "\n Player C won:" + cWin/num);
    }


    public static void main(String[] args) {
        int n = 10000000;
        duel3D(n);
    }
}
