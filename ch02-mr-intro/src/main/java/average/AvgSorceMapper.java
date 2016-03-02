package average;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;

public class AvgSorceMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
        String line = value.toString();
        StringTokenizer tokenizer = new StringTokenizer(line);
        while (tokenizer.hasMoreElements()) {
            String strName = tokenizer.nextToken();
            String strSorce = tokenizer.nextToken();
            System.out.println("strName: " + strName + " strScore: " + strSorce);
            context.write(new Text(strName), new IntWritable(Integer.parseInt(strSorce)));
        }
    }
}