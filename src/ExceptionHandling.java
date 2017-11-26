import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Ikram
 * Date: 11/26/17
 * Time: 2:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class ExceptionHandling {
        private int integerValue;
        private double doubleValue ;
        private int[] intArray;
        private FileInputStream inputStream;
        private String testString;

        public ExceptionHandling(){
            integerValue = 5;
            doubleValue = 10.0;
            intArray = new int[] {1,2,3,4,5};
            testString = "Test";
        }
        public void expectionHandling(){
            try {
                File file = new File("./tmp.txt");
                inputStream = new FileInputStream(file);

                // intentional error
                integerValue = Integer.parseInt(testString);

                // this line of code will never be reached
                System.out.println("int value = " + integerValue);

                // ArrayIndexOutOfRange Exception
                integerValue = intArray [5];

                // this will never executed
                System.out.println("int value = " + integerValue);

            }
            catch(FileNotFoundException ex){
                System.out.print(ex);
            }
            // Be Specific in Exception handling , if you specify illegalArgumentException , You will not be to identify the real cause of issue
            catch (NumberFormatException ex) {
                System.out.print(ex);
            }
            catch(ArrayIndexOutOfBoundsException ex){
                System.out.print(ex);
            }
            catch (IllegalArgumentException ex){
                System.out.print(ex);
            }
            catch(Exception ex){
                System.out.print(ex);
            }
                  // As finally block will always executed , so we can put our close resources things here
                 // rather than putting as final statement of try which may not be able to execute in case of execption
                //  in one of top instructions before close.
            finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        System.out.print(e);
                    }
                }
            }
        }


    public static void main(String args[]){
        ExceptionHandling exceptionHandlingInstance = new ExceptionHandling();
        exceptionHandlingInstance.expectionHandling();
    }
}



