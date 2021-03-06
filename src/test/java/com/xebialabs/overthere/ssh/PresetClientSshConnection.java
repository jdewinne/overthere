/*
 * Copyright (c) 2008-2013, XebiaLabs B.V., All rights reserved.
 *
 *
 * Overthere is licensed under the terms of the GPLv2
 * <http://www.gnu.org/licenses/old-licenses/gpl-2.0.html>, like most XebiaLabs Libraries.
 * There are special exceptions to the terms and conditions of the GPLv2 as it is applied to
 * this software, see the FLOSS License Exception
 * <http://github.com/xebialabs/overthere/blob/master/LICENSE>.
 *
 * This program is free software; you can redistribute it and/or modify it under the terms
 * of the GNU General Public License as published by the Free Software Foundation; version 2
 * of the License.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 51 Franklin St, Fifth
 * Floor, Boston, MA 02110-1301  USA
 */
package com.xebialabs.overthere.ssh;

import static com.xebialabs.overthere.ssh.SshConnectionBuilder.SSH_PROTOCOL;

import com.xebialabs.overthere.util.DefaultAddressPortMapper;
import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.common.Factory;

import com.xebialabs.overthere.ConnectionOptions;
import com.xebialabs.overthere.OverthereFile;
import com.xebialabs.overthere.RuntimeIOException;

public class PresetClientSshConnection extends SshConnection {

    public PresetClientSshConnection(ConnectionOptions options, final SSHClient clientToReturn) {
        super(SSH_PROTOCOL, options, new DefaultAddressPortMapper());
        sshClientFactory = new Factory<SSHClient>() {
            @Override
            public SSHClient create() {
                return clientToReturn;
            }
        };
    }

    @Override
    public OverthereFile getFile(String hostPath)
        throws RuntimeIOException {
        throw new UnsupportedOperationException("TODO Auto-generated method stub");
    }

}