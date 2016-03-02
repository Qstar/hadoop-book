package dataSort;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

//map将输入中的value化成IntWritable类型，作为输出的key
public class SortMapper extends Mapper<Object, Text, IntWritable, IntWritable> {
    private static IntWritable data = new IntWritable();

    //实现map函数
    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException{
        String line = value.toString();
        data.set(Integer.parseInt(line));
        context.write(data, new IntWritable(1));
    }
}