package hadoop;
import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import org.apache.hadoop.fs.*;

public class mr4 {

  public static class TokenizerMapper
       extends Mapper<Object, Text, Text, IntWritable>{

    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();

    public void map(Object key, Text value, Context context
                    ) throws IOException, InterruptedException {
      String str[] = value.toString().split(";");
      
     word.set(str[0]);   //STATE
     one.set(Integer.parseInt(str[8]));     //income
        context.write(word, one);
      
      
    }
  }

  public static class IntSumReducer
       extends Reducer<Text,IntWritable,Text,IntWritable> {
    private IntWritable result = new IntWritable();

    public void reduce(Text key, Iterable<IntWritable> values,
                       Context context
                       ) throws IOException, InterruptedException {
      int sum = 0;
      int avg=0;
      int i=0;
      for (IntWritable val : values) {
        sum += val.get();
      i++;
      }
      avg = sum / i;
      result.set(avg);
      context.write(key, result);
    }
  }

  public static void startmr(String[] args) throws Exception {
    Configuration conf = new Configuration();
    FileSystem fs=FileSystem.get(conf);
     
     if(fs.exists(new Path(args[1])))
     fs.delete(new Path(args[1]));
    Job job = Job.getInstance(conf, "word count");
    job.setJarByClass(mr4.class);
    job.setMapperClass(TokenizerMapper.class);
    job.setCombinerClass(IntSumReducer.class);
    job.setReducerClass(IntSumReducer.class);
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(IntWritable.class);
    FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));
    
    if(  job.waitForCompletion(true))
   System.out.println("Done successfully HCL");
  }
  }

