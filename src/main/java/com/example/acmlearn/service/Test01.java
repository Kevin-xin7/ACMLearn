public class Test01 {

    //快速排序算法练习
    //挖坑法+分治法
    public static void quicksort(int a[],int l,int r) {

        if ( l < r) {
            //如果是将最中间的值作为基准，这先将第一个和最中间的数交换
            //swap(a[l],a[l+(r-l)/2])
            int i = l,j = r,x = a[l];
            while ( i < j ) {

                //从后往前找，找到第一个比x小的数
                while ( i < j && a[j] >= x) {
                    j--;
                }

                if (i < j) {

                    //将a[j]填到前面a[i]的坑里
                    a[i++] = a[j];

                }

                //从前往后找，找到一个比x大的值填到a[j]的坑里
                while (i < j && a[i] < x) {
                    i++;
                }

                if ( i < j) {

                    a[j--] = a[i];
                }

            }

            //一轮排序过后，a[i]成了最左边那个数，也就是基准数x
            a[i] = x;
            quicksort(a,l,i-1);
            quicksort(a,i+1,r);

        }

    }

    public static void main(String[] args) {
        int[] a = new int[]{7,3,2,8,9,5,32,6,1,88};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+"\t");
        }

        quicksort(a,0,9);
        System.out.println("\n");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+"\t");
        }
    }


}
