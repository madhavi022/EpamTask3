package epamtask;
/*Protection of the Indian border and safe transport of items from one point to another along the border are the paramount jobs for the Indian army. However they need some information about the protection status along the length of the border. The border can be viewed as the real x-axis. Along the axis, Indian army has N checkpoints for lookout. 

We know that each checkpoint is located at an integer location xi. Each checkpoint must have a fleet of armed men which are responsible for guarding the neighboring areas of the checkpoint and provide military assistance of all kinds. The size of the fleet is based on the location of the checkpoint and how active the region is for terrorist activities. 

Given the number of armed men assigned at the ith checkpoint, as pi, this information is available for all checkpoints. 
With the skills of the armed men, it is known that if for the ith checkpoint, the length on the x axis that they can defend is a closed interval [xi-pi, xi+pi].*/
import java.io.*;
import java.lang.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import static java.lang.Math.*;
public class Army implements Runnable {
    public static void main(String[] args) {
        new Thread(null, new Army(), "Check2", 1 << 28).start();// to increse stack size in java
    }
    void init(ArrayList <Integer> adj[], int n){
        for(int i=0;i<=n;i++)adj[i]=new ArrayList<>();
    }
    static long mod = (long) (1e9+7);
    public void run() {
        InputReader in = new InputReader(System.in);
        PrintWriter w = new PrintWriter(System.out);
 
        int n=in.nextInt();
        long s=in.nextLong();
        long e=in.nextLong();
        army p[]=new army[n];
        for(int i=0;i<n;i++){
            p[i]=new army();
            long x=in.nextLong();
            long y=in.nextLong();
            p[i].x=x-y;
            p[i].y=x+y;
        }
        long ans=0;
        int co=0;
        Arrays.sort(p,new cmp());
        if(s==e){
            w.println(0);
            w.close();
            return;
        }
        int gg=0;
        for(int i=0;i<n;){
            if(p[i].y<s){
                i++;
                continue;
            }
            if(p[i].x>=s&&co==0){
                co=1;
                ans+=p[i].x-s;
            }
            long max=p[i].y;
            int j=i+1;
            while (j<n&&p[j].x<=max){
                max=max(max,p[j].y);
                j++;
            }
            if(j<n){
                co=1;
                ans+=max(0,min(e,p[j].x)-max(s,max));
            }
            else{
                if(max<=e)ans+=e-max;
            }
            i=j;
            gg=1;
        }
        if(gg==0)ans=e-s;
        w.println(ans);
 
 
        w.close();
    }
    class cmp implements Comparator<army>{
        public int compare(army o1,army o2){
            return o1.x<o2.x?-1:o1.x>o2.x?1:o1.y<o2.y?1:o1.y>o2.y?-1:0;
        }
    }
    class army{
        long x,y;
    }
    class pair {
        int a;
        long b;
        pair(int a,long b){
            this.a=a;
            this.b=b;;
        }
        public boolean equals(Object obj) {      //  override equals method for object to remove tem from arraylist and sets etc.......
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            pair other = (pair) obj;
            if (b!= other.b||a!=other.a)
                return false;
            return true;
        }
    }
    long modinv(long a,long b)
    {
        long p=power(b,mod-2);
 
        p=a%mod*p%mod;
        p%=mod;
 
        return p;
 
    }
    long power(long x,long y){
        if(y==0)return 1%mod;
        if(y==1)return x%mod;
        long res=1;
        x=x%mod;
        while(y>0){
            if((y%2)!=0){
                res=(res*x)%mod;
            }
            y=y/2;
            x=(x*x)%mod;
        }
        return res;
    }
    long gcd(long a,long b){
 
        if(b==0)return a;
        return gcd(b,a%b);
    }
    void sev(int a[],int n){
 
        for(int i=2;i<=n;i++)a[i]=i;
        for(int i=2;i<=n;i++){
 
            if(a[i]!=0){
                for(int j=2*i;j<=n;){
 
                    a[j]=0;
                    j=j+i;
                }
            }
 
        }
 
    }
    static class InputReader
    {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
 
        public InputReader(InputStream stream)
        {
            this.stream = stream;
        }
 
        public int read()
        {
            if (numChars==-1)
                throw new InputMismatchException();
 
            if (curChar >= numChars)
            {
                curChar = 0;
                try
                {
                    numChars = stream.read(buf);
                }
                catch (IOException e)
                {
                    throw new InputMismatchException();
                }
 
                if(numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }
 
        public String nextLine()
        {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String stock = "";
            try
            {
                stock = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return stock;
        }
        public int nextInt()
        {
            int c = read();
 
            while(isSpaceChar(c))
                c = read();
 
            int sgn = 1;
 
            if (c == '-')
            {
                sgn = -1;
                c = read();
            }
 
            int res = 0;
            do
            {
                if(c<'0'||c>'9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
 
            return res * sgn;
        }
 
        public long nextLong()
        {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-')
            {
                sgn = -1;
                c = read();
            }
            long res = 0;
 
            do
            {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
            return res * sgn;
        }
 
        public double nextDouble()
        {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-')
            {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.')
            {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.')
            {
                c = read();
                double m = 1;
                while (!isSpaceChar(c))
                {
                    if (c == 'e' || c == 'E')
                        return res * Math.pow(10, nextInt());
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }
 
        public String readString()
        {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do
            {
                res.appendCodePoint(c);
                c = read();
            }
            while (!isSpaceChar(c));
 
            return res.toString();
        }
 
        public boolean isSpaceChar(int c)
        {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
 
        public String next()
        {
            return readString();
        }
 
        public interface SpaceCharFilter
        {
            public boolean isSpaceChar(int ch);
        }
    }
}