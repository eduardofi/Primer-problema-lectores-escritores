/**
 * Factory.java
 *
 * Esta clase crea los hilos correspondientes a los lectores y escritores,
 * y el objeto compartido, por estos.
 */

public class Factory
{
    public static final int NUM_OF_READERS = 3;
    public static final int NUM_OF_WRITERS = 2;

   public static void main(String args[])
   {
      ReadWriteLock server = new DataBaseSemaphore();

      Thread[] readerArray = new Thread[NUM_OF_READERS];
      Thread[] writerArray = new Thread[NUM_OF_WRITERS];

      for (int i = 0; i < NUM_OF_READERS; i++) {
         readerArray[i] = new Thread(new Reader(i, server));
         readerArray[i].start();
      }

      for (int i = 0; i < NUM_OF_WRITERS; i++) {
         writerArray[i] = new Thread(new Writer(i, server));
         writerArray[i].start();
      }
   }
}
