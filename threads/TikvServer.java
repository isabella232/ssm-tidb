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

import com.sun.jna.Library;
import com.sun.jna.Native;

public class TikvServer implements Runnable {
  private String args;
  private Tikv tikv;

  public interface Tikv extends Library {
    void startServer(String args);

    boolean isTikvServerReady();
  }

  public TikvServer(String args) {
    this.args = args;
    try {
      tikv = (Tikv) Native.loadLibrary("libtikv.so", Tikv.class);
    } catch (UnsatisfiedLinkError ex) {
      System.out.println("libtikv.so is not found!");
    }
  }

  public Tikv getTikv() {
    return tikv;
  }

  public void run() {
    StringBuffer strbuffer = new StringBuffer();
    //According to start.rs in the tikv source code, "TiKV" is the flag name used for parsing
    strbuffer.append("TiKV");
    strbuffer.append(" ");
    strbuffer.append(args);

    System.out.println("Starting TiKV..");
    tikv.startServer(strbuffer.toString());
  }
}
