package MultipleTableJoin;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;

/*
* 在map中先区分输入行属于左表还是右表，然后对两列值进行分割，
* 保存连接列在key值，剩余列和左右表标志在value中，最后输出
*/

public class MTjoinMapper extends Mapper<Object, Text, Text, Text> {
    @Override
    // 实现map函数

    public void map(Object key, Text value, Context context) throws IOException, InterruptedException{
        String line = value.toString();// 每行文件
        String relationtype = "";// 左右表标识
        // 输入文件首行，不处理
        if (line.contains("factoryname") || line.contains("addressed")) {
            return;
        }
        // 输入的一行预处理文本
        StringTokenizer itr = new StringTokenizer(line);
        String mapkey = "";
        String mapvalue = "";
        int i = 0;
        while (itr.hasMoreTokens()) {
            // 先读取一个单词
            String token = itr.nextToken();
            // 判断该地址ID就把存到"values[0]"
            if (token.charAt(0) >= '0' && token.charAt(0) <= '9') {
                mapkey = token;
                if (i > 0) {
                    relationtype = "1";
                } else {
                    relationtype = "2";
                }
                continue;
            }
            // 存工厂名
            mapvalue += token + " ";
            i++;
        }
        // 输出左右表
        context.write(new Text(mapkey), new Text(relationtype + "+" + mapvalue));
    }
}