package com.cmd;

import org.kohsuke.args4j.Option;

public class ZkExecutorCmdOpts {

	@Option(name = "-h", usage = "Zookeeper host address (host:port)", required = true)
	private String zkHost;

	@Option(name = "-o", usage = "Provide the operation name e.g 'create', 'read', 'update', 'delete', 'list'", required = true)
	private String opType;

	@Option(name = "-p", usage = "Path", required = false)
	private String path;

	@Option(name = "-m", usage = "Provide data to be store or update", required = false)
	private String message;

	public String getZkHost() {
		return zkHost;
	}

	public void setZkHost(String zkHost) {
		this.zkHost = zkHost;
	}

	public String getOpType() {
		return opType;
	}

	public void setOpType(String opType) {
		this.opType = opType;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
