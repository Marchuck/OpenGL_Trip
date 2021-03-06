package com.luk.tinykartpreacher;


import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class SecondCube {

//	private float vertices[] = { 
//			 1,  1, -1,// p0 - topFrontRight
//			 1, -1, -1, // p1 bottomFront Right
//			-1, -1, -1, // p2 bottomFront Left
//			-1,  1, -1, // p3 top Front Left
//			 1,  1,  1, // p4
//			 1, -1,  1, // p5
//			-1, -1,  1, // p6
//			-1,  1,  1, // p7
//	};
	private float vertices[] = { 
			 3,  0.2f, -0.2f,// p0 - topFrontRight
			 3, -0.2f, -0.2f, // p1 bottomFront Right
			-0.2f, -0.2f, -0.2f, // p2 bottomFront Left
			-0.2f,  0.2f, -0.2f, // p3 top Front Left
			 3,  0.2f,  0.2f, // p4
			 3, -0.2f,  0.2f, // p5
			-0.2f, -0.2f,  0.2f, // p6
			-0.2f,  0.2f,  0.2f, // p7
	};
	
	
	private FloatBuffer vertBuff;

	private short[] pIndex = { 
			3,4,0, 0,4,1, 3,0,1,
			3,7,4, 7,6,4, 7,3,6,
			3,1,2, 1,6,2, 6,3,2,
			1,4,5, 5,6,1, 6,5,4
			
	};
//	private float rgbaVals[] = { 
//			1, 1, 0, 0.5f,
//			.25f, 0, .85f, 1,
//			0,1, 1, 1
//			};
	

//	private ShortBuffer colorBuff;

	private ShortBuffer pBuff;

	public SecondCube() {
		ByteBuffer bBuff = ByteBuffer.allocateDirect(vertices.length * 4);
		bBuff.order(ByteOrder.nativeOrder());
		vertBuff = bBuff.asFloatBuffer();
		vertBuff.put(vertices);
		vertBuff.position(0);

		ByteBuffer pbBuff = ByteBuffer.allocateDirect(pIndex.length * 2);
		pbBuff.order(ByteOrder.nativeOrder());
		pBuff = pbBuff.asShortBuffer();
		pBuff.put(pIndex);
		pBuff.position(0);
		
	}

	public void draw(GL10 gl) {
		gl.glFrontFace(GL10.GL_CW);
		gl.glEnable(GL10.GL_CULL_FACE);
		gl.glCullFace(GL10.GL_BACK);
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glColor4f(0.2f, 0.3f, 0.6f, 1.0f);	
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertBuff);
		gl.glDrawElements(GL10.GL_TRIANGLES, pIndex.length,
				GL10.GL_UNSIGNED_SHORT, pBuff);
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glDisable(GL10.GL_CULL_FACE);
	}
}
