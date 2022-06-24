import com.training.collections.list.Iterator;
import com.training.collections.list.List;
import com.training.collections.list.linkedlist.LinkedList;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class Test {


    static List ll;

    static void test_add(String expected, String explanation)
    {
        ll.add(expected);
        if (ll.getAt(ll.size() - 1).equals(expected))
        {
            System.out.println("[ OK ] " + explanation + " add(" + expected + ") = [" + ll.getAt(ll.size() - 1) + "]");
        }
        else
        {
            System.out.println("[Error] " + explanation + " add(" + expected + ") = [" + ll.getAt(ll.size() - 1) + "]");
        }
    }

    static void test_getAt(int index, String expected, String explanation)
    {
        if (ll.getAt(index).equals(expected))
        {
            System.out.println("[ OK ] " + explanation + " getAt(" + index + ") = [" + expected + "]");
        }
        else
        {
            System.out.println("[Error] " + explanation + " getAt(" + index + ") = [" + expected + "]");
        }
    }

    static void test_setAt(int index, String expected, String explanation)
    {
        ll.setAt(index, expected);
        if (ll.getAt(index).equals(expected))
        {
            System.out.println("[ OK ] " + explanation + " setAt(" + index + ") = [" + ll.getAt(index) + "], expected [" + expected + "]");
        }
        else
        {
            System.out.println("[Error] " + explanation + " setAt(" + index + ") = [" + ll.getAt(index) + "], expected [" + expected + "]");
        }
    }

    static void test_insert(int index, String expected, String explanation)
    {
        ll.insert(index, expected);
        if (ll.getAt(index).equals(expected))
        {
            System.out.println("[ OK ] " + explanation + " insert(" + index + ") = [" + ll.getAt(index) + "], expected [" + expected + "] current size " + ll.size());
        }
        else
        {
            System.out.println("[Error] " + explanation + " insert(" + index + ") = [" + ll.getAt(index) + "], expected [" + expected + "] current size " + ll.size());
        }
    }

    static void test_remove(int index, String expected, String explanation)
    {
        ll.remove(index);
        if (ll.getAt(index).equals(expected))
        {
            System.out.println("[ OK ] " + explanation + " after remove(" + index + ") = value [" + ll.getAt(index) + "], expected [" + expected + "] current size " + ll.size());
        }
        else
        {
            System.out.println("[Error] " + explanation + " after remove(" + index + ") = value [" + ll.getAt(index) + "], expected [" + expected + "] current size " + ll.size());
        }
    }

    static void test_contains(String data, boolean expected, String explanation)
    {
        if (ll.contains(data) == expected)
        {
            System.out.println("[ OK ] " + explanation + " check contains(" + data + ") = " + expected + " current size " + ll.size());
        }
        else
        {
            System.out.println("[Error] " + explanation + " check contains(" + data + ") = " + expected + " current size " + ll.size());
        }
    }

    public static void main(String[] args) throws IOException {
        ll = new LinkedList();
        //ll = new ArrayList();


        test_getAt(0, "", "Obtain 1st element of 0 entered");
        test_setAt(0, "", "Set 'zero' at 1st element of 0 entered");
        test_remove(0, "", "remove first element of 0 entered");

        test_add("uno", "inserting 'uno'");

        test_getAt(0, "uno", "Obtain 1st element of 1 entered");
        test_getAt(1, "", "Obtain 2nd element of 1 entered");

        test_add("dos", "inserting 'dos'");
        test_add("III", "inserting 'III'");
        test_add("IV", "inserting 'IV'");
        test_add("Milo", "inserting 'Milo'");

        test_getAt(-1, "", "Obtain -1th element of 5 entered");
        test_getAt(0, "uno", "Obtain 1st element of 5 entered");
        test_getAt(1, "dos", "Obtain 2nd element of 5 entered");
        test_getAt(2, "III", "Obtain 3rd element of 5 entered");
        test_getAt(3, "IV", "Obtain 4th element of 5 entered");
        test_getAt(4, "Milo", "Obtain 5th element of 5 entered");
        test_getAt(8, "", "Obtain 9th element of 5 entered");

        test_setAt(2, "tri", "Set 3rd element as 'tri'" );
        test_setAt(0, "one", "Set 1st element as 'one'" );
        test_setAt(4, "5th", "Set last element as '5th'" );

        test_insert(0, "zero", "Insert 'zero' at initial position");
        test_insert(5, "six", "Insert 'six' at position 6");
        test_insert(3, "3+1", "Insert '3+1' at position 4");
        test_insert(9, "", "Insert 'nine' at position 9");


        Iterator it = ll.iterator();
        System.out.println("Contents");
        while (it.hasNext())
        {
            System.out.println("->" + it.next());
        }

        test_remove(0, "one", "remove first element");
        test_remove(6, "", "remove 7th element");
        test_remove(2, "tri", "remove 3rd element");
        test_remove(9, "", "remove 9th element of 6");

        test_contains("one", true, "Contains 'one'");
        test_contains("dos", true, "Contains 'dos'");
        test_contains("six", true, "Contains 'six'");
        test_contains("3+1", false, "Contains '3+1'");

        ll.removeAll();

        test_contains("one", false, "Contains 'one'");
        test_contains("dos", false, "Contains 'dos'");
        test_contains("six", false, "Contains 'six'");

    }
}
