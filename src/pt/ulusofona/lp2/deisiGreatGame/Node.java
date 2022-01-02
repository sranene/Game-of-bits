    package pt.ulusofona.lp2.deisiGreatGame;

    public class Node {
        Programmer programmer;
        Node next;

        public Node(Programmer programmer) {
            this.programmer = programmer;
            this.next = null;
        }

        public Programmer getProgrammer(){
            return programmer;
        }


    }
