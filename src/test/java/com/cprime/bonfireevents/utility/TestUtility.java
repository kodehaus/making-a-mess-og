package com.cprime.bonfireevents.utility;

import java.util.Calendar;
import java.util.Date;

public class TestUtility {
    public static final Date TOMORROW = GET_NOW_PLUS_DAYS(1);
    public static final Date NEXT_DAY = GET_NOW_PLUS_DAYS(2);
    public static final Date THIRD_DAY = GET_NOW_PLUS_DAYS(3);

    public static Date GET_NOW_PLUS_DAYS(int howManyDays) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, howManyDays); // number represents number of days
        Date yesterday = cal.getTime();
        return yesterday;
    }
}
