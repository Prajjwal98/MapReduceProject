package hadoop;
import org.apache.hadoop.util.*;
import java.util.*;

public class definition
{
	String state[]=new String[100];
	String worker []=new String [100];
definition()
{	
state[1]="Alabama/AL";
state[2]="Alaska/AK";
state[4]="Arizona/AZ";
state[5]="Arkansas/AR";
state[6]="California/CA";
state[8]="Colorado/CO";
state[9]="Connecticut/CT";
state[10]="Delaware/DE";
state[11]="District of Columbia/DC";
state[12]="Florida/FL";
state[13]="Georgia/GA";
state[15]="Hawaii/HI";
state[16]="Idaho/ID";
state[17]="Illinois/IL";
state[18]="Indiana/IN";
state[19]="Iowa/IA";
state[20]="Kansas/KS";
state[21]="Kentucky/KY";
state[22]="Louisiana/LA";
state[23]="Maine/ME";
state[24]="Maryland/MD";
state[25]="Massachusetts/MA";
state[26]="Michigan/MI";
state[27]="Minnesota/MN";
state[28]="Mississippi/MS";
state[29]="Missouri/MO";
state[30]="Montana/MT";
state[31]="Nebraska/NE";
state[32]="Nevada/NV";
state[33]="New Hampshire/NH";
state[34]="New Jersey/NJ";
state[35]="New Mexico/NM";
state[36]="New York/NY";
state[37]="North Carolina/NC";
state[38]="North Dakota/ND";
state[39]="Ohio/OH";
state[40]="Oklahoma/OK";
state[41]="Oregon/OR";
state[42]="Pennsylvania/PA";
state[44]="Rhode Island/RI";
state[45]="South Carolina/SC";
state[46]="South Dakota/SD";
state[47]="Tennessee/TN";
state[48]="Texas/TX";
state[49]="Utah/UT";
state[50]="Vermont/VT";
state[51]="Virginia/VA";
state[53]="Washington/WA";
state[54]="West Virginia/WV";
state[55]="Wisconsin/WI";
state[56]="Wyoming/WY";
state[72]="Puerto Rico/PR";

worker[1] = "Employee of a private for-profit company or business, or of an individual, for wages, salary or commissions";
worker[2] = "Employee of a private not-for-profit, tax-exempt, or charitable organization";
worker[3] = "Local government employee (city, county, etc.)";
worker[4] = "State government employee";
worker[5] = "Federal government employee";
worker[6] = "Self-employed in own not incorporated business, professional practice, or farm";
worker[7] = "Self-employed in own incorporated business, professional practice or farm";
worker[8] = "Working without pay in family business or farm";
worker[9] = "Unemployed and last worked 5 years ago or earlier or never worked";

}	
String get_state(int i)
{
	return state[i];
}

String get_worker(int i)
{
	return worker[i];
}

}

