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

public class Launch implements Runnable {

  public void run() {
    String pdArgs = new String("--data-dir=pd --log-file=logs/pd.log");
    String tikvArgs = new String("--pd=127.0.0.1:2379 --data-dir=tikv --log-file=logs/tikv.log");
    String tidbArgs = new String("--store=tikv --path=127.0.0.1:2379 --log-file=logs/tidb.log --P=4000 --lease=10s");
    //String tidbArgs = new String("--log-file=logs/tidb.log");

    PdServer pdServer = new PdServer(pdArgs);
    TikvServer tikvServer = new TikvServer(tikvArgs);
    TidbServer tidbServer = new TidbServer(tidbArgs);

    Thread pdThread = new Thread(pdServer);
    pdThread.start();
    try {
      while (!pdServer.isReady()) {
        System.out.println("waiting Pd server..");
        Thread.sleep(100);
      }
      System.out.println("Pd server is ready.");

      Thread tikvThread = new Thread(tikvServer);
      tikvThread.start();
      while (!tikvServer.isReady()) {
        System.out.println("waiting Tikv server..");
        Thread.sleep(100);
      }
      System.out.println("Tikv server is ready.");

      Thread tidbThread = new Thread(tidbServer);
      tidbThread.start();
      while (!tidbServer.isReady()) {
        System.out.println("waiting Tidb server..");
        Thread.sleep(100);
      }
      System.out.println("Tidb server is ready.");

      pdThread.join();
      tikvThread.join();
      tidbThread.join();
    } catch (InterruptedException ex) {
      System.out.println(ex.getMessage());
    }
  }
}
