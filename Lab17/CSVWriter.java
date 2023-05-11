import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class CSVWriter extends FileWriter {
        private int initialLineLength;
        public CSVWriter(File file) throws IOException {
                super(file);
        }
        public CSVWriter(String pathName) throws IOException {
                super(pathName);
        }
        public void writeln(String[] stringsForALine) throws IOException, EntryOutOfBoundsException {
                if(stringsForALine.length != initialLineLength)
                        throw new EntryOutOfBoundsException(initialLineLength + " String(s) expected; " +
                                                            stringsForALine.length + " String(s) called");
                for(int i = 0; i <= stringsForALine.length-1; i++) {
                        if(i <= stringsForALine.length-2)
                                super.write(stringsForALine[i] + ",");
                        else
                                super.write(stringsForALine[i] + "\n");
                }
        }
        public void setInitialLineLength(int initialLineLength) {
                this.initialLineLength = initialLineLength;
        }
}
