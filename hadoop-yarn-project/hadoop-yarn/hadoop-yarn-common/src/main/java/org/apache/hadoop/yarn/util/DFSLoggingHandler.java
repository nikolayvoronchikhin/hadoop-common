/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.yarn.util;

import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.yarn.api.records.ApplicationId;
import org.apache.hadoop.yarn.api.records.ContainerId;
import org.apache.hadoop.yarn.conf.YarnConfiguration;

/**
 * Base class to handle DFS logging related operations.
 * Sub-classes should provide DFS specific behavior.
 */
public abstract class DFSLoggingHandler {
  /**
   * Returns the stdout redirection command to be used. This input to this
   * command is the stdout generated by the task.
   *
   * @param stdoutFile name of the file to which stdout will be redirected
   * @return stdout redirection command
   */
  public abstract String getStdOutCommand(String stdoutFile);

  /**
   * Returns the stderr redirection command to be used. This input to this
   * command is the stderr generated by the task.
   *
   * @param stdoutFile name of the file to which stdout will be redirected
   * @return stderr redirection command
   */
  public abstract String getStdErrCommand(String stderrFile);

  /**
   * Returns the absolute log directory to write to.
   *
   * @param relative path of the specific container directory to write to
   * @return absolute log directory
   */
  public Path getLogDirForWrite(String relativeContainerLogDir)
    throws IOException {

    return new Path(TaskLogUtil.getPropertyValue(
          YarnConfiguration.NM_LOG_DIRS), relativeContainerLogDir);
  }

  /**
   * Returns the absolute log directories that contains logs for the given
   * application. An application can contain one or more containers and each
   * container logs can potentially be stored in different directories. Hence
   * an array of paths is returned.
   *
   * @param applicationId application ID
   * @return absolute log directories that contain the given application logs
   */
  public Path[] getLogDir(ApplicationId applicationId) throws IOException {
    return new Path[] {getLogDirForWrite(applicationId.toString())};
  }

  /**
   * Returns the absolute log directory that contains logs for the given
   * container.
   *
   * @param containerId container ID
   * @return absolute log directory that contain then given container logs
   */
  public Path getLogDir(ContainerId containerId) throws IOException {
    String dir = containerId.getApplicationAttemptId().getApplicationId().toString()
      + Path.SEPARATOR
      + containerId.toString();

    return getLogDirForWrite(dir);
  }
}
