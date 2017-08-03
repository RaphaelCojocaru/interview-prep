package Twitter;

public class Solution1 {
	/*
		 
	select sum(distinct a.TIV_2012) from INSURANCE a, INSURANCE b
	where (a.TIV_2011 = b.TIV_2011) and (a.PID != b.PID)
	and (((select count(PID) from INSURANCE where LAT = a.LAT) = 1) or ((select count(PID) from INSURANCE where LON = a.LON) = 1));
	 
	 */
}
