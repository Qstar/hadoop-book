package MultipleTableJoin;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

// 1.export HADOOP_CLASSPATH=hadoop-examples.jar
// 2.command: ../hadoop-2.7.2/bin/hadoop MultipleTableJoin/MTjoin input/MultipleTableJoin/ output

public class MTjoin {
    public static void main(String[] args) throws Exception{
        if (args.length != 2) {
            System.err.println("Usage: Multiple Table Join <input path> <output path>");
            System.exit(-1);
        }
        Job job = Job.getInstance();
        job.setJarByClass(MTjoin.class);
        job.setJobName("MTjoin");

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        job.setMapperClass(MTjoinMapper.class);
        job.setReducerClass(MTjoinReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}