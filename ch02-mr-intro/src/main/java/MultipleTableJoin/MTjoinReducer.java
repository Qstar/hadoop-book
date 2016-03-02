package MultipleTableJoin;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class MTjoinReducer extends Reducer<Text, Text, Text, Text> {
    public static int time = 0;

    // 实现reduce函数
    public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException{
        // 输出表头
        if (0 == time) {
            context.write(new Text("factoryname"), new Text("addressname"));
            time++;
        }
        int factorynum = 0;
        String[] factory = new String[10];
        int addressnum = 0;
        String[] address = new String[10];
        Iterator ite = values.iterator();
        while (ite.hasNext()) {
            String record = ite.next().toString();
            int len = record.length();
            int i = 2;
            if (0 == len) {
                continue;
            }
            // 取得左右表标识
            char relationtype = record.charAt(0);
            // 左表
            if ('1' == relationtype) {
                factory[factorynum] = record.substring(i);
                factorynum++;
            }
            // 右表
            if ('2' == relationtype) {
                address[addressnum] = record.substring(i);
                addressnum++;
            }

        }
        // 求笛卡尔积
        if (0 != factorynum && 0 != addressnum) {
            for (int m = 0; m < factorynum; m++) {
                for (int n = 0; n < addressnum; n++) {
                    // 输出结果
                    context.write(new Text(factory[m]), new Text(address[n]));
                }
            }
        }
    }
}