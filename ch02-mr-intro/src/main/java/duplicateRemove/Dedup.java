package duplicateRemove;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

// 1.export HADOOP_CLASSPATH=hadoop-examples.jar
// 2.command: ../hadoop-2.7.2/bin/hadoop duplicateRemove/Dedup input/duplicateFile/ output

public class Dedup {
    public static void main(String[] args) throws Exception{
        if (args.length != 2) {
            System.err.println("Usage: MaxTemperature <input path> <output path>");
            System.exit(-1);
        }

        Job job = Job.getInstance();
        job.setJobName("Data Deduplication");
        job.setJarByClass(Dedup.class);


        //设置Map、Combine和Reduce处理类
        job.setMapperClass(DedupMapper.class);
        job.setCombinerClass(DedupReducer.class);
        job.setReducerClass(DedupReducer.class);

        //设置输出类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        //设置输入和输出目录

        FileInputFormat.addInputPath(job, new Path(args[0]));

        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        System.exit(job.waitForCompletion(true) ? 0 : 1);

    }

}