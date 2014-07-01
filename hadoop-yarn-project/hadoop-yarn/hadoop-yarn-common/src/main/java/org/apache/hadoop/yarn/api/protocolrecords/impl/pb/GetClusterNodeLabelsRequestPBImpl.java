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

package org.apache.hadoop.yarn.api.protocolrecords.impl.pb;

<<<<<<< HEAD
import org.apache.hadoop.yarn.api.protocolrecords.GetClusterNodeLabelsRequest;

import com.google.protobuf.TextFormat;
import org.apache.hadoop.yarn.proto.YarnServiceProtos.GetClusterNodeLabelsRequestProto;

public class GetClusterNodeLabelsRequestPBImpl extends
    GetClusterNodeLabelsRequest {

  GetClusterNodeLabelsRequestProto proto = GetClusterNodeLabelsRequestProto
      .getDefaultInstance();
=======
import org.apache.hadoop.classification.InterfaceAudience.Private;
import org.apache.hadoop.classification.InterfaceStability.Unstable;
import org.apache.hadoop.yarn.api.protocolrecords.GetClusterNodeLabelsRequest;
import org.apache.hadoop.yarn.proto.YarnServiceProtos.GetClusterNodeLabelsRequestProto;
import com.google.protobuf.TextFormat;

@Private
@Unstable
public class GetClusterNodeLabelsRequestPBImpl extends
    GetClusterNodeLabelsRequest {

  GetClusterNodeLabelsRequestProto proto =
      GetClusterNodeLabelsRequestProto.getDefaultInstance();
>>>>>>> MAPR-14424: Implementation for 'mapred job -showlabels' and 'mapred job -refreshlabaels' cli command
  GetClusterNodeLabelsRequestProto.Builder builder = null;
  boolean viaProto = false;

  public GetClusterNodeLabelsRequestPBImpl() {
    builder = GetClusterNodeLabelsRequestProto.newBuilder();
  }

<<<<<<< HEAD
  public GetClusterNodeLabelsRequestPBImpl(GetClusterNodeLabelsRequestProto proto) {
=======
  public GetClusterNodeLabelsRequestPBImpl(
      GetClusterNodeLabelsRequestProto proto) {
>>>>>>> MAPR-14424: Implementation for 'mapred job -showlabels' and 'mapred job -refreshlabaels' cli command
    this.proto = proto;
    viaProto = true;
  }

  public GetClusterNodeLabelsRequestProto getProto() {
<<<<<<< HEAD
=======
    mergeLocalToProto();
>>>>>>> MAPR-14424: Implementation for 'mapred job -showlabels' and 'mapred job -refreshlabaels' cli command
    proto = viaProto ? proto : builder.build();
    viaProto = true;
    return proto;
  }

  @Override
  public int hashCode() {
    return getProto().hashCode();
  }

  @Override
  public boolean equals(Object other) {
<<<<<<< HEAD
    if (other == null)
      return false;
=======
    if (other == null) {
      return false;
    }
>>>>>>> MAPR-14424: Implementation for 'mapred job -showlabels' and 'mapred job -refreshlabaels' cli command
    if (other.getClass().isAssignableFrom(this.getClass())) {
      return this.getProto().equals(this.getClass().cast(other).getProto());
    }
    return false;
  }

  @Override
  public String toString() {
    return TextFormat.shortDebugString(getProto());
  }
<<<<<<< HEAD
=======

  private void mergeLocalToBuilder() {
  }

  private void mergeLocalToProto() {
    if (viaProto) {
      maybeInitBuilder();
    }
    mergeLocalToBuilder();
    proto = builder.build();
    viaProto = true;
  }

  private void maybeInitBuilder() {
    if (viaProto || builder == null) {
      builder = GetClusterNodeLabelsRequestProto.newBuilder(proto);
    }
    viaProto = false;
  }
>>>>>>> MAPR-14424: Implementation for 'mapred job -showlabels' and 'mapred job -refreshlabaels' cli command
}
