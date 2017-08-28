# Launch-TiDB

1. For PD, modify Makefile and cmd/pd-server/main.go.
2. For Tikv, add mod src/kvserver which is modified based on src/bin and add callkv as an entry.
3. For TiDB, modify Makefile and tidb-server/main.go.
