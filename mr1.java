/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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


class mr1 {

  public static class TokenizerMapper
       extends Mapper<Object, Text, Text, IntWritable>{

    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();

    public void map(Object key, Text value, Context context
                    ) throws IOException, InterruptedException {

       StringTokenizer itr = new StringTokenizer(value.toString(),";");

        String pid =itr.nextToken();
             String nam = itr.nextToken();
             String price = itr.nextToken();
                    word.set(pid+";"+nam+";"+price+";");
             
                     //one.set(Integer.parseInt(price));
				one.set(1);


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
      for (IntWritable val : values) {
        sum += val.get();
      }
      result.set(sum);

      context.write(key, result);
    }
  }

  public static void startmr(String arg[]) throws Exception {
     Configuration conf = new Configuration();
     FileSystem fs=FileSystem.get(conf);
     
     if(fs.exists(new Path(arg[1])))
     fs.delete(new Path(arg[1]));
     System.out.println(arg[0]+","+arg[1]);
    Job job = Job.getInstance(conf, "word count");
    job.setJarByClass(mr1.class);
    job.setMapperClass(TokenizerMapper.class);
    //job.setCombinerClass(IntSumReducer.class);
    //job.setReducerClass(IntSumReducer.class);
    job.setNumReduceTasks(0);
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(IntWritable.class);
    FileInputFormat.addInputPath(job, new Path(arg[0]));
    FileOutputFormat.setOutputPath(job, new Path(arg[1]));
    
   if(  job.waitForCompletion(true))
   System.out.println("Done successfully HCL");
  }
  
 
}
