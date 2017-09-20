//#[cfg(test)]
//mod tests {
//    #[test]
//    fn it_works() {
//    }
//}

use std::ffi::CStr;
use std::os::raw::c_char;
use std::str;


extern crate tikv;

#[no_mangle]
pub extern fn startServer(cmd_args: *const c_char) {
    let cmd_bytes = unsafe { CStr::from_ptr(cmd_args).to_bytes() };
    let cmd_string = str::from_utf8(cmd_bytes).unwrap().to_string();
    let cmd_vec: Vec<&str> = cmd_string.split(' ').collect();

    tikv::kvserver::start::main(cmd_vec);
}

#[no_mangle]
pub fn isTikvServerReady() -> bool {
    return tikv::kvserver::start::isTikvServerReady();
}