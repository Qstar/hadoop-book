// cc URLCat Displays files from a Hadoop filesystem on standard output using a URLStreamHandler

import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.io.IOUtils;

import java.io.InputStream;
import java.net.URL;


// hadoop fs -copyFromLocal input/docs/quangle.txt hdfs://localhost/user/tom/quangle.txt
// vv URLCat

//1. export HADOOP_CLASSPATH=hadoop-examples.jar
//2. ../hadoop-2.7.2/bin/hadoop URLCat hdfs://localhost/user/tom/quangle.txt
public class URLCat {

    static{
        URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
    }

    public static void main(String[] args) throws Exception{
        InputStream in = null;
        try {
            in = new URL(args[0]).openStream();
            IOUtils.copyBytes(in, System.out, 4096, false);
        } finally {
            IOUtils.closeStream(in);
        }
    }
}
// ^^ URLCat
