package SingleTableJoin;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;

/*
* map将输出分割child和parent，然后正序输出一次作为右表，
* 反序输出一次作为左表，需要注意的是在输出的value中必须
* 加上左右表的区别标识。
*/
public class STjoinMapper extends Mapper<Object, Text, Text, Text> {
    @Override
    // 实现map函数
    public void map(Object key, Text value, Context context) throws IOException, InterruptedException{
        String childname;// 孩子名称
        String parentname;// 父母名称
        String relationtype;// 左右表标识

        // 输入的一行预处理文本
        StringTokenizer itr = new StringTokenizer(value.toString());
        String[] values = new String[2];
        int i = 0;
        while (itr.hasMoreTokens()) {
            values[i] = itr.nextToken();
            i++;
        }

        if (values[0].compareTo("child") != 0) {
            childname = values[0];
            parentname = values[1];
            // 输出左表
            relationtype = "1";
            context.write(new Text(values[1]), new Text(relationtype + "+" + childname + "+" + parentname));
            // 输出右表
            relationtype = "2";
            context.write(new Text(values[0]), new Text(relationtype + "+" + childname + "+" + parentname));
        }
    }
}