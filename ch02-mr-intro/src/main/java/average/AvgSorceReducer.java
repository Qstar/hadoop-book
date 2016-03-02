package average;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class AvgSorceReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
    public void reduce(Text key, Iterable<IntWritable> values, Context context)
            throws IOException, InterruptedException{
        int sum = 0;
        int num = 0;
        for (IntWritable sorce : values) {
            sum += sorce.get();
            num++;
        }
        context.write(key, new IntWritable((int) (sum / num)));
    }
}