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

public class PdServer implements Runnable {
  private String args;
  private Pd pd;

  public interface Pd extends Library {
    void startServer(String args);

    boolean isPdServerReady();
  }

  public PdServer(String args) {
    this.args = args;
    try {
      pd = (Pd) Native.loadLibrary("libpd.so", Pd.class);
    } catch (UnsatisfiedLinkError ex) {
      System.out.println("Unable to load native library due to unsatisfied link error!");
    }
  }

  public boolean isReady() {
    return pd.isPdServerReady();
  }

  public void run() {
    System.out.println("Starting PD..");
    pd.startServer(args);
  }
}
