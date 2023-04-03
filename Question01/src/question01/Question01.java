/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question01;

/**
 *
 * @author Jaylon
 */
public class Question01 {

    /**
     * @param args the command line arguments
     */
    static class Node {

        int value;
        Node next;
    }

    static class Stack {

        Node Top;

        Stack() {
            Top = null;                  //null needed starting stack

        }

        void pop() {
            Top = Top.next;            //Removes top of stack with whatever is next
        }

        void push(int x) {              //Create new node with value a pointer
            Node node = new Node();

            node.value = x;
            node.next = Top;
            Top = node;              //Update for next new node
        }

        void print() {                  //print all of stack
            Node cur = Top;            //Create Current node so Top won't change
            while (cur != null) {
                System.out.print(cur.value + ", ");
                cur = cur.next;
            }

        }

        void printFirstLast() {     //Print top of stack and last element
            Node cur = Top;
            System.out.println("");
            System.out.println("The first element is " + Top.value);
            //Find last element to print
            while (cur.next != null) {
                cur = cur.next;
            }
            System.out.println("The last element is " + cur.value);
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        //Create Stack
        Stack st = new Stack();
        // Operations 
        st.push(21);
        st.push(32);
        st.push(46);
        st.push(78);
        st.push(17);
        st.push(92);
        st.push(68);
        st.push(88);
        st.push(40);
        st.push(7);

        st.pop();

        st.print();
        st.printFirstLast();
    }

}
