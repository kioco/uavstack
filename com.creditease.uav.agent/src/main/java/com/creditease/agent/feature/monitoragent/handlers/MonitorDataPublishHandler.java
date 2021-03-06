/*-
 * <<
 * UAVStack
 * ==
 * Copyright (C) 2016 - 2017 UAVStack
 * ==
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * >>
 */

package com.creditease.agent.feature.monitoragent.handlers;

import com.creditease.agent.log.SystemLogger;
import com.creditease.agent.log.api.ISystemLogger;
import com.creditease.agent.monitor.api.MonitorDataFrame;

/**
 * MonitorDataPublishHandler helps to publish monitor data frame to messaging system
 * 
 * @author zhen zhang
 *
 */
public class MonitorDataPublishHandler extends AbstractPublishHandler<MonitorDataFrame> {

    public MonitorDataPublishHandler(String cName, String feature) {
        super(cName, feature);
    }

    @Override
    protected String getMessageKey() {

        return MonitorDataFrame.MessageType.Monitor.toString();
    }

    @Override
    protected String getMessage(MonitorDataFrame t) {

        return t.toJSONString();
    }

    @Override
    protected ISystemLogger getLogger(String cName, String feature) {

        return SystemLogger.getLogger("MonitorLog", feature + ".monitor.%g.%u.log", "INFO", false, 5 * 1024 * 1024);
    }
}
