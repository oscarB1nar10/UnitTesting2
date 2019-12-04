package com.example.unittesting2.unittesting2.util

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInfo
import org.junit.jupiter.api.TestReporter
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.random.Random

class DateUtilTest {
    private val TODAY = "11-2019"

    @Test
     fun testGetCurrentTimeStamp(){
       assertDoesNotThrow {
           assertEquals(TODAY, DateUtil.getCurrentTimeStamp())
           println("Timestamp is generated correctly")
       }
    }

    @ParameterizedTest
    @ValueSource(ints = [0,1,2,3,4,5,6,7,8,9,10,11])
    fun testGetMonthFromNumber(monthNumber: Int, testInfo: TestInfo, testReporter: TestReporter){
        assertEquals(DateUtil.months[monthNumber],
            DateUtil.getMonthFromNumber(DateUtil.monthNumbers[monthNumber]))
        println("${DateUtil.monthNumbers[monthNumber]}: ${DateUtil.months[monthNumber]}")
    }

    @ParameterizedTest
    @ValueSource(ints = [1,2,3,4,5,6,7,8,9,10,11])
    fun testGetMonthFromNumberWithError(monthNumber: Int, testInfo: TestInfo, testReporter: TestReporter){
        var randomInt = Random.nextInt(90)+13
        println((monthNumber * randomInt).toString())
        assertEquals(DateUtil.getMonthFromNumber((monthNumber * randomInt).toString()),
        DateUtil.GET_MONTH_ERROR)
        println("${DateUtil.monthNumbers[monthNumber]}: ${DateUtil.GET_MONTH_ERROR}")
    }
}