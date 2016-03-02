package InvertedIndex;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;
import java.util.StringTokenizer;

/*
* map将输出分割child和parent，然后正序输出一次作为右表，
* 反序输出一次作为左表，需要注意的是在输出的value中必须
* 加上左右表的区别标识。
*/
public class InvertedIndexMapper extends Mapper<Object, Text, Text, Text> {
    // 实现map函数
    private Text keyInfo = new Text(); // 存储单词和URL组合
    private Text valueInfo = new Text(); // 存储词频
    private FileSplit split; // 存储Split对象

    // 实现map函数
    public void map(Object key, Text value, Context context) throws IOException, InterruptedException{
        // 获得<key,value>对所属的FileSplit对象
        split = (FileSplit) context.getInputSplit();
        StringTokenizer itr = new StringTokenizer(value.toString());
        while (itr.hasMoreTokens()) {
            // key值由单词和URL组成，如"MapReduce：file1.txt"
            // 获取文件的完整路径
            // keyInfo.set(itr.nextToken()+":"+split.getPath().toString());
            // 这里为了好看，只获取文件的名称。
            int splitIndex = split.getPath().toString().indexOf("file");
            keyInfo.set(itr.nextToken() + ":" + split.getPath().toString().substring(splitIndex));
            // 词频初始化为1
            valueInfo.set("1");
            context.write(keyInfo, valueInfo);
        }
    }
}