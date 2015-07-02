package com.cronutils.model.time;

import com.cronutils.model.CronType;
import com.cronutils.model.definition.CronDefinitionBuilder;
import com.cronutils.parser.CronParser;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
 * Copyright 2015 jmrozanec
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class ExecutionTimeCron4jIntegrationTest {

    private CronParser cron4jCronParser;
    private static final String EVERY_MONDAY_AT_18 = "0 18 * * 1";

    @Before
    public void setUp(){
        cron4jCronParser = new CronParser(CronDefinitionBuilder.instanceDefinitionFor(CronType.CRON4J));
    }

    @Test
    public void testForCron() throws Exception {
        assertEquals(ExecutionTime.class, ExecutionTime.forCron(cron4jCronParser.parse(EVERY_MONDAY_AT_18)).getClass());
    }


    public void testNextExecutionOverNextExecution() throws Exception {
        DateTime now = DateTime.now();
        ExecutionTime executionTime = ExecutionTime.forCron(cron4jCronParser.parse(EVERY_MONDAY_AT_18));
        //TODO complete
        DateTime next = executionTime.nextExecution(now);
        System.out.println(next);
        System.out.println(executionTime.nextExecution(next));
    }
}
