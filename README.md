# modification

1. For PD, modify Makefile and cmd/pd-server/main.go.
2. For Tikv, add mod src/kvserver which is modified based on src/bin and add callkv as an entry.
3. For TiDB, modify Makefile and tidb-server/main.go.

# build prerequisite

1. build rocksdb.
   https://github.com/pingcap/docs/blob/3e186ac6d49e30659531a6864fc78f1519282556/scripts/build_rocksdb.sh
2. install golang in /usr/local/.
3. install rust. Only nightly version is valid.
   https://www.rust-lang.org/en-US/other-installers.html
