package dataSort;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

// 1.export HADOOP_CLASSPATH=hadoop-examples.jar
// 2.command: ../hadoop-2.7.2/bin/hadoop dataSort/Sort input/dataSort/ output

public class Sort {
    public static void main(String[] args) throws Exception{
        if (args.length != 2) {
            System.err.println("Usage: Sort <input path> <output path>");
            System.exit(-1);
        }

        Job job = Job.getInstance();
        job.setJobName("Data Sort");
        job.setJarByClass(Sort.class);

        //设置Map、Reduce处理类
        job.setMapperClass(SortMapper.class);
        job.setReducerClass(SortReducer.class);

        //设置输出类型
        job.setOutputKeyClass(IntWritable.class);
        job.setOutputValueClass(IntWritable.class);

        //设置输入和输出目录

        FileInputFormat.addInputPath(job, new Path(args[0]));

        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        System.exit(job.waitForCompletion(true) ? 0 : 1);

    }

}