package average;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

// 1.export HADOOP_CLASSPATH=hadoop-examples.jar
// 2.command: ../hadoop-2.7.2/bin/hadoop average/AvgSorce input/scorelist/ output

public class AvgSorce {
    public static void main(String[] args) throws Exception{
        if (args.length != 2) {
            System.err.println("Usage: AvgSorce <input path> <output path>");
            System.exit(-1);
        }
        Job job = Job.getInstance();
        job.setJarByClass(AvgSorce.class);
        job.setJobName("AvgSorce");

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        job.setMapperClass(AvgSorceMapper.class);
        job.setReducerClass(AvgSorceReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}