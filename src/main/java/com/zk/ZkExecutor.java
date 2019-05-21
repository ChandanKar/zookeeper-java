package com.zk;

import java.util.ArrayList;
import java.util.List;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

import com.cmd.ZkExecutorCmdOpts;

public class ZkExecutor {

	public static void main(String[] args) throws Exception {

		ZkExecutorCmdOpts options = new ZkExecutorCmdOpts();
		CmdLineParser parser = new CmdLineParser(options);

		ZkOperation zkOperation = null;
		try {
			parser.parseArgument(args);
		} catch (CmdLineException e) {
			System.err.println(e.getMessage());
			parser.printUsage(System.err);
			return;
		}

		String zkAddress = options.getZkHost();
		String opType = options.getOpType();
		String path = options.getPath();
		String message = options.getMessage();

		if (zkAddress != null && zkAddress != "") {

		} else {
			System.err.println("Zookeeeper host can not be null or empty!!");
			return;
		}

		switch (opType) {
		case "create": {
			zkOperation = new ZkOperation(zkAddress);
			zkOperation.create(path, message.getBytes());
			System.out.println("--------------------");
			System.out.println("Message created!!");
			System.out.println("--------------------");
			break;
		}
		case "read": {
			zkOperation = new ZkOperation(zkAddress);
			byte[] data = zkOperation.read(path);
			System.out.println("--------------------");
			System.out.println("Messages:\t" + (new String(data)));
			System.out.println("--------------------");
			break;
		}
		case "update": {
			zkOperation = new ZkOperation(zkAddress);
			zkOperation.update(path, message.getBytes());
			System.out.println("--------------------");
			System.out.println("Message updated!!");
			System.out.println("--------------------");
			break;
		}
		case "delete": {
			zkOperation = new ZkOperation(zkAddress);
			zkOperation.delete(path);
			System.out.println("--------------------");
			System.out.println("ZNode deleted!!");
			System.out.println("--------------------");
			break;
		}
		case "list": {
			System.out.println("Operation not implemented");
			zkOperation = new ZkOperation(zkAddress);
			List<String> childs = zkOperation.getClildNodes(path);
			System.out.println("--------------------");
			int i = 0;
			for (String child : childs) {
				System.out.println("child[" + i++ + "] : \t" + child);
			}
			System.out.println("--------------------");
			break;
		}
		default:
			System.err.println("No such operation type!!");
			break;

		}

	}

}
