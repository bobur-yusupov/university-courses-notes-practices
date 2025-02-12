/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package beachballexample;

/**
 *
 * @author ytajdi
 */

class BeachBall {
       private String color;
       private int size;
       
       public BeachBall(String color, int size) {
           this.color = color;
           this.size = size;
       }
       
       public String getColor() {
           return this.color;
       }
       
       public void setColor(String newColor) {
           this.color = newColor;
       }
       
       public int getSize() {
           return this.size;
       }
       
       public void setSize(int newSize) {
           this.size = newSize;
       }
       
       public void inflate() {
           this.size++;
       }
       
       public void deflate() {
           this.size--;
       }
}

public class BeachBallExample {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        BeachBall b1 = new BeachBall("red", 10);
        System.out.println(b1.getSize());
        
        b1.inflate();
        
        System.out.println(b1.getColor());
        System.out.println(b1.getSize());
    }
    
}
