/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.util.jar.*;
import java.util.zip.*;

File f = new File( basedir, "massembly-285-assembly/target/massembly-285-assembly-1-bin.jar" )
JarFile jf = new JarFile( f );

String testPath = "tests/App.class"

int jarCount = 0

Enumeration e = jf.entries()
while( e.hasMoreElements() )
{
    if ( testPath.equals( String.valueOf( e.nextElement() ) ) )
    {
        jarCount++
    }
}
jf.close()

assert jarCount == 1 : "Test path: ${testPath} was found ${jarCount} times (should have been 1).\nArchive: ${f}"

f = new File( basedir, "massembly-285-assembly/target/massembly-285-assembly-1-bin.zip" )
ZipFile zf = new ZipFile( f )

int zipCount = 0

e = zf.entries()
while( e.hasMoreElements() )
{
    if ( testPath.equals( String.valueOf( e.nextElement() ) ) )
    {
        zipCount++
    }
}
zf.close()

assert zipCount == 1 : "Test path: ${testPath} was found ${zipCount} times (should have been 1).\nArchive: ${f}"
