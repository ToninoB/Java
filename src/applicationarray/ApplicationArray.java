/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationarray;

/**
 *
 * @author Tonino
 */

import java.util.*;
import java.nio.*;

 
public class ApplicationArray 
{
    
     public enum ConstantLst { ITEM1, ITEM2, ITEM3 };
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
             
        int[] ArrayOfInt1;
        ArrayOfInt1 = new int[100];
        System.out.println(ArrayOfInt1.length);
        
        System.out.println(ArrayOfInt1[0]);
        
        int[] ArrayOfInt2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println(ArrayOfInt2.length);
        System.out.println(ArrayOfInt2[0]);
        
        ArrayOfInt1 = ArrayOfInt2;
        System.out.println(ArrayOfInt1.length);
        System.out.println(ArrayOfInt1[0]);
        
         ArrayOfInt1[1] = 55;
         System.out.println(ArrayOfInt1[1]);
         System.out.println(ArrayOfInt2[1]);
         
         ArrayOfInt2 = ArrayOfInt1.clone();
         ArrayOfInt1[1] = 444;
         System.out.println(ArrayOfInt1[1]);
         System.out.println(ArrayOfInt2[1]);
         
       for(int i = 0; i != (ArrayOfInt1.length - 1); i++)
       {
           System.out.println(ArrayOfInt1[i]);
       }
       
       
       for(int x : ArrayOfInt1)
       {
           System.out.println(x);
       }
         
       // System.arraycopy(ArrayOfInt1, 2, ArrayOfInt2, 0, 7);
       java.util.Arrays.fill(ArrayOfInt2, 123);
       System.out.println(ArrayOfInt1[5]);
       
       java.util.Arrays.sort(ArrayOfInt1);
       for(int x : ArrayOfInt1)
       {
           System.out.println(x);
       }
       
       int y = ArrayOfInt2[0];
       
       for(int x : ArrayOfInt1)
       {
           y = Math.max(x, y);
       }
       System.out.println(y);
       int idx = java.util.Arrays.binarySearch(ArrayOfInt1, y);
       System.out.println(idx);
       
       int[] ArrayOfInt3;
       ArrayOfInt3 = new int[100];
       
       byte b = 'a';
       char c = (char)b;
       System.out.println(c);
       
       ArrayList<Byte> al1= new ArrayList(10);
       al1.add((byte)15); al1.add((byte)24);
       al1.add((byte)37); al1.add((byte)40);
       
       System.out.println(al1);
       System.out.println(al1.get(0));
       
       System.out.println(al1.get(0).toString());
       
       Byte b2 = al1.get(0);
       System.out.println(b2);
       b2 = al1.get(1);
       System.out.println(b2);
       
       for(Byte el : al1)
       {
           System.out.println(el);
       }
       
       Byte[] arb;
       arb = new Byte[al1.size()];
       arb = al1.toArray(arb);
       for(Byte el : arb)
       {
           System.out.println(el);
       }
       
       byte[] data;
       data = new byte[5];

        byte i = 0;
        for(Byte el : al1)
        {
            data[i++] = (byte) el;
        }
        for(byte el2 : data)
        {
            System.out.format("%d ", el2);
        }
        System.out.println();
        
        // ByteBuffer class
        ByteBuffer buffer1 = ByteBuffer.allocate(12);
        System.out.println(buffer1.hasRemaining());
        System.out.println(buffer1.capacity());
        System.out.println(buffer1.position());
        
        buffer1.put((byte)111);
        System.out.println(buffer1);
        buffer1.putShort((short)513);
        buffer1.putInt(0x10203040);
                   
        i = buffer1.get();      // Does not remove byte in associated array
                 
        byte[] buffer1array = buffer1.array();
        System.out.println(buffer1array);
        System.out.println(buffer1array.length);
        System.out.println(buffer1array[0]);
        System.out.println(buffer1array[1]);
        System.out.println(buffer1array[2]);
        System.out.println(buffer1array[3]);
        System.out.println(buffer1array[4]);
        System.out.println(buffer1array[5]);
        System.out.println(buffer1array[6]);
        
       short a1 = (short)0x1234;
       short a2 = (short)0xA050;
       short a3 = (short)0xC25B;
       int c1 = 0;
       c1 = (a1 ^ a2 ^ a3) & 0xFFFF;
       System.out.format("%x\n", c1);
       System.out.format("%x\n", (c1/256) ^ (c1&255));
         
       buffer1.clear();
       buffer1.putInt(0x01020304);
       buffer1.putInt(0x10203040);
       buffer1.putInt(0xA4C271E5);
       c1 = 0;
     
       System.out.println(buffer1.position());
       System.out.println(buffer1.rewind());
       System.out.println(buffer1.position());
       
       
     
       for(; buffer1.hasRemaining() ;)
       {
           c1 = c1 ^ buffer1.getInt();
       }
       System.out.format("%x\n", c1);
       
       int c2 = 0;
       for(i = 4; i != 0; i--)
       {
           c2 = c2 ^ (c1 & 0xFF);
           c1 = c1 >> 8;
       }
       System.out.format("%x\n", c1);
       System.out.format("%x\n", c2);
     
       System.out.println(buffer1.position());
       
       buffer1.rewind();
       buffer1.put((byte)0x10);
       buffer1.put((byte)0xFF);
       
       byte b1 = 0;
       buffer1.rewind();
       b1 = buffer1.get();
       b1 = (b1 == 0x10) ? (byte)(buffer1.get() - 0x10) : b1;
       System.out.format("%x\n", b1);
       
       
       System.out.println("Buffer to Array checksum and substitute byte");
       byte chk = 0;
       
       buffer1.rewind();
       buffer1.put((byte)0x02);
       buffer1.put((byte)0x30);
       buffer1.putInt(0x10447788);
       buffer1.putInt(0x1012AA55);
       buffer1.put((byte)0x00);
       buffer1.put((byte)0x03);
       
       
       buffer1array = buffer1.array();
       
       buffer1.position(2);
       for(i = 0; buffer1.hasRemaining(); i++)
       {
           b1 = buffer1.get();
           b1 = (b1 == 0x10) ? (byte)(buffer1.get() - 0x10) : b1;
           buffer1array[i] = b1;
            chk = (byte)(chk ^ b1);
       }
       
       for(byte ba : buffer1array)
       {
           System.out.format("%x\n", ba);
       }
       
       // Byte Array to String (of Char)
       System.out.format("[index-2]: %x\n", buffer1array[i - 2]);
       System.out.format("Checksum: %x\n", chk);
       
       byte HardwareRev;
       String SoftwareRev = "";
       String SerialNumber = "";
       
       byte[] RxBuffer = { ' ', 3, '0','2','.', '0', '7', '1', '2', '3', '4', '5', '6', '7', '8'};
       
       HardwareRev = RxBuffer[1];
       
       char[] helloArray = { 'h', 'e', 'l', 'l', 'o', '.'};
       String helloString = new String(helloArray);
       System.out.println( helloString );
       
       SoftwareRev = new String(RxBuffer, 2, 5); // Get 5 next ASCII characters (pos, length)
       System.out.println(SoftwareRev);
       
       SerialNumber = new String(RxBuffer, 7, 8);
       System.out.println(SerialNumber);
       System.out.println(HardwareRev);
       
       boolean flg;
       i = 0;
       flg = (i == 1);
       System.out.println(flg);
       
       int cc = 0x71140201;
       
       cc = (byte)( (cc & 0xFF) ^ (cc >> 8 & 0xFF)
                        ^ (cc >> 16 & 0xFF) ^ (cc >> 24 & 0xFF) );
       
       System.out.format("Checksum: %2x\n", cc);
       
       b1 = 0x2;
       b1 = (byte)(((b1 & 0x2) != 0) ? 1 : 0);
       
       System.out.println(b1);
       
       String[] str1 = { "1", "2", "3" };
       ConstantLst constantList1;
       
       ArrayList<String> alist = new ArrayList<>();
       
       for(String s : str1)
       {
           alist.add(s);
       }
       
       System.out.println(alist);
             
       String text = "bY = ";
       Byte bY = (byte)0xa4;
       System.out.println(text.concat(String.format("%02x", bY)));
       
    }
}