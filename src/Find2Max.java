import java.util.Stack;

public class Find2Max {

    public static class Node{
        int data;
        Stack<Integer> st;

        public Node(int a){
            data=a;
            st = new Stack<>();
        }
    }

    public static void findMax(int[] arr ) {
        Node[] ans = new Node[arr.length];
        int t = 0;
        int last=Integer.MIN_VALUE;


        for (int i = 0; i <ans.length ; i++) {
            ans[i]= new Node(arr[i]);
        }

        while (ans.length != 1) {
            if(arr.length%2!=0) {
                last = arr[arr.length-1];
                t=1;
            }
            else t=0;
            Node[] temp = new Node[(ans.length-t/2)];
            int index=0;
            for (int i = 0; i < ans.length-1; i=i+2) {
                if(ans[i].data>ans[i+1].data){
                    temp[index]=ans[i];
                    temp[index].st.push(ans[i+1].data);
                }
                else{
                    temp[index]= ans[i+1];
                    temp[index].st.push(ans[i].data);
                }
                index++;
            }

            ans = temp;

        }
        int max1 = ans[0].data;
        int max2 = ans[0].st.pop();
        while(!ans[0].st.isEmpty()){
            if(ans[0].st.peek()>max2){
                max2 = ans[0].st.pop();
            }
            else{
                ans[0].st.pop();
            }
        }


        System.out.println("Max 1: " + max1 + " Max2 " + max2);
    }

    public static void main(String[] args) {
        int[] arr = {1,5,7,2,19,4,9};
        findMax(arr);


    }




}





