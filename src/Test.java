import java.util.*;

class Student{
     Student(int g){
        grade=g;
    }
    public int grade;
}
class SortingStudentsByGPA implements Comparator<Student> {
    void quickSort(Student[] numbers, int left, int right)
    {
        Student pivot;
        int l_hold = left;
        int r_hold = right;
        pivot = numbers[left];
        while (left < right)
        {
            while (compare(numbers[right],pivot)==1 ||(compare(numbers[right],pivot)==0)&& (left < right))
                right--;
            if (left != right)
            {
                Student tmp = numbers[left];
                numbers[left] = numbers[right];
                numbers[right] = tmp;
                left++;
            }
            while (compare(numbers[left],pivot)==-1 ||(compare(numbers[left],pivot)==0) && (left < right))
                left++;
            if (left != right)
            {
                Student tmp = numbers[left];
                numbers[left] = numbers[right];
                numbers[right] = tmp;
                right--;
            }
        }
        numbers[left] = pivot;
        int pivot1 = left;
        left = l_hold;
        right = r_hold;
        if (left < pivot1)
            quickSort(numbers, left, pivot1 - 1);
        if (right > pivot1)
            quickSort(numbers, pivot1 + 1, right);
    }



    @Override
    public int compare(Student a, Student b) {

        int sum=b.grade-a.grade;
        if(sum>0)
            return 1;
        if(sum==0)
            return 0;
        if(sum<0)
            return -1;
        return sum;
    }
}


public class Test {
    public static void main(String[] args) {
        int n = 10;
        Student[] students= new Student[n];
        for(int i=0;i<n;i++)
            students[i]=new Student((int)(Math.random()*10));

        SortingStudentsByGPA sort=new SortingStudentsByGPA();
        int[] IDNumber = new int[n];
        for(int i=0;i<n;i++)
            IDNumber[i]=(int)(Math.random()*10);
        for(int a: IDNumber)
            System.out.println(a);
        Arrays.sort(IDNumber);
        System.out.println("!!!!!!!!!!!!!!!");
        for(int a: IDNumber)
            System.out.println(a);
        System.out.println("!!!!!!!!!!!!!!!");
        for(Student o: students){
            System.out.println(o.grade);
        }
        System.out.println("-----------------");
        sort.quickSort(students,0,9);
        for(Student o: students){
            System.out.println(o.grade);
        }

    }

}
